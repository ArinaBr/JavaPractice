package ru.mirea.exercise;

public class Algorithm {
    public static void main(String[] args) {
        System.out.println("The boyer-moore algorithm");
        System.out.println();
        System.out.println("Source string:");
        System.out.println("The greatest happiness is to feel loved");
        System.out.println("Search string:");
        System.out.println("feel");
        System.out.println("Index of the search string in the source string:");
        System.out.println(indexOf("The greatest happiness is to feel loved", "feel"));
    }

    public static int indexOf(String haystack, String needle) {
        return indexOf(haystack.toCharArray(), needle.toCharArray());
    }

    public static int indexOf(char[] haystack, char[] needle) {
        if(needle.length == 0) {
            return 0;
        }
        int charTable[] = makeCharTable(needle);
        int offsetTable[] = makeOffsetTable(needle);
        for(int i = needle.length - 1, j; i < haystack.length;) {
            for(j = needle.length - 1; needle[j] == haystack[i]; --i, --j) {
                if (j == 0) {
                    return i;
                }
            }
            i += Math.max(offsetTable[needle.length - 1 - j], charTable[haystack[i]]);
        }
        return -1;
    }

    private static int[] makeCharTable(char[] needle) {
        final int size = 256;
        int[] table = new int[size];
        for(int i = 0; i < table.length; ++i) {
            table[i] = needle.length;
        }
        for(int i = 0; i < needle.length - 1; ++i) {
            table[needle[i]] = needle.length - 1 - i;
        }
        return table;
    }

    private static int[] makeOffsetTable(char[] needle) {
        int[] table = new int[needle.length];
        int lastPrefixPosition = needle.length;
        for(int i = needle.length - 1; i >= 0; --i) {
            if(isPrefix(needle, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            table[needle.length - 1 - i] = lastPrefixPosition - i + needle.length - 1;
        }
        for(int i = 0; i < needle.length - 1; ++i) {
            int slen = suffixLength(needle, i);
            table[slen] = needle.length - 1 - i + slen;
        }
        return table;
    }

    private static boolean isPrefix(char[] needle, int p) {
        for(int i = p, j = 0; i < needle.length; ++i, ++j) {
            if (needle[i] != needle[j]) {
                return false;
            }
        }
        return true;
    }

    private static int suffixLength(char[] needle, int p) {
        int len = 0;
        for(int i = p, j = needle.length - 1; i >= 0 && needle[i] == needle[j]; --i, --j) {
            len += 1;
        }
        return len;
    }
}
