public class AccessChecker {
    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("public".equals(fieldModifier)) return "ALLOWED";
        
        if ("private".equals(fieldModifier)) {
            return "SAME_CLASS".equals(accessorContext) ? "ALLOWED" : "DENIED";
        }
        
        if ("default".equals(fieldModifier)) {
            return ("SAME_CLASS".equals(accessorContext) || "SAME_PACKAGE".equals(accessorContext)) 
                    ? "ALLOWED" : "DENIED";
        }
        
        if ("protected".equals(fieldModifier)) {
            if ("SAME_CLASS".equals(accessorContext) || 
                "SAME_PACKAGE".equals(accessorContext) || 
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
                return "ALLOWED";
            }
            return "DENIED";
        }
        
        return "DENIED";
    }

    public static String summarizeByModifier(String[][] attempts) {
        int[] priv = new int[2]; // 0: allowed, 1: denied
        int[] def = new int[2];
        int[] prot = new int[2];
        int[] pub = new int[2];

        for (String[] attempt : attempts) {
            if (attempt.length < 2) continue;
            String mod = attempt[0];
            String ctx = attempt[1];
            boolean isAllowed = "ALLOWED".equals(classifyAccess(mod, ctx));

            switch (mod) {
                case "private": if (isAllowed) priv[0]++; else priv[1]++; break;
                case "default": if (isAllowed) def[0]++; else def[1]++; break;
                case "protected": if (isAllowed) prot[0]++; else prot[1]++; break;
                case "public": if (isAllowed) pub[0]++; else pub[1]++; break;
            }
        }
        
        return String.format("private: %d allowed / %d denied | default: %d allowed / %d denied | protected: %d allowed / %d denied | public: %d allowed / %d denied",
                priv[0], priv[1], def[0], def[1], prot[0], prot[1], pub[0], pub[1]);
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].length >= 2) {
                String mod = attempts[i][0];
                String ctx = attempts[i][1];
                if ("DENIED".equals(classifyAccess(mod, ctx))) {
                    return mod + " via " + ctx + " (attempt #" + (i + 1) + ")";
                }
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        
        String[][] summaryBatch = {
            {"private", "SAME_CLASS"}, {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"}, {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"}, {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(summaryBatch));

        String[][] firstDeniedBatch1 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(firstDeniedBatch1));

        String[][] firstDeniedBatch2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(firstDeniedBatch2));
    }
}