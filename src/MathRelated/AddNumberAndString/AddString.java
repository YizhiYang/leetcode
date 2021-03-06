package MathRelated.AddNumberAndString;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * 思路: 正常的加法，用 % 和 / 去取的结果和carry。最后记得要reverse。 跟正常的add two numbers一样的logic
 */

public class AddString {

    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;  // 注意 可以通过 - '0' 得到数字
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }

        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
