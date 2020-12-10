package nestedclass;

/**
 * local class example
 * 检查一个手机号码是不是 11 位
 *
 * @author 文通
 * @since 2019/5/21
 */
public class LocalClassExample {

    static String regularExpression = "[^0-9]";

    // 检查手机号码的格式是否正确
    public static void validatePhoneNumber(String phoneNumber) {
        int numberLength = 11;
        // numberLength = 9;// 这样会使 numberLength 变成非 effectively final，然后编译不通过
        // 格式化手机号码
        class PhoneNumber {
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber) {
                String currentNumber = phoneNumber.replaceAll(regularExpression, "");
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber);
            }
        }
        // numberLength = 9;// 这样会使 numberLength 变成非 effectively final，然后编译不通过

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber);
        myNumber1.printOriginalNumbers();
        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
    }

    public static void main(String... args) {
        validatePhoneNumber("185-1111-2222");
    }
}
