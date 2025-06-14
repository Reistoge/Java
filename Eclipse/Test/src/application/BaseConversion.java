package application;

import java.math.BigInteger;

public class BaseConversion {


    public static String GeneralBaseConversion(String number, int baseOriginal, int baseGoal, int precision) {

            if (baseOriginal < 2 || baseGoal < 2) {
                return "error de base";
            }
            if (baseOriginal == baseGoal) {
                return number;
            }
            String[] parts = number.split("[.]");
            if (parts.length == 1) {
                if (baseOriginal == 10) {
                    return deleteExtraZero(decToBaseX(new BigInteger(parts[0]), baseGoal));
                } else if (baseGoal == 10) {
                    return baseXToDec(parts[0], baseOriginal).toString();
                } else {
                    return deleteExtraZero(decToBaseX(baseXToDec(parts[0], baseOriginal), baseGoal));
                }
            } else if (parts.length == 2) {
                String integerPart = GeneralBaseConversion(parts[0], baseOriginal, baseGoal, precision);
                String fractionalPart;
                if (baseOriginal == 10) {
                    fractionalPart = getFractionalPart(Double.parseDouble("0." + parts[1]), baseGoal, precision);
                } else if (baseGoal == 10) {
                    fractionalPart = Double.toString(getDecimalPart(parts[1], baseOriginal)).substring(2, 2 + precision);
                } else {
                    fractionalPart = getFractionalPart(getDecimalPart(parts[1], baseOriginal), baseGoal, precision);
                }
                return integerPart + "." + fractionalPart;
            }


        return "error de sintaxis";
    }

    private static String decToBaseX(BigInteger number, int base) {
        if (number.equals(BigInteger.ZERO)) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (number.compareTo(BigInteger.ZERO) > 0) {
            result.insert(0, numberToChar(number.mod(BigInteger.valueOf(base)).intValue()));
            number = number.divide(BigInteger.valueOf(base));
        }
        return result.toString();
    }

    private static BigInteger baseXToDec(String number, int base) {
        BigInteger decimal = BigInteger.ZERO;
        for (int i = 0; i < number.length(); i++) {
            decimal = decimal.multiply(BigInteger.valueOf(base))
                    .add(BigInteger.valueOf(charToNumber(number.charAt(i))));
        }
        return decimal;
    }

    private static char numberToChar(int number) {
        return (char) (number <= 9 ? '0' + number : 'A' + (number - 10));
    }

    private static int charToNumber(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        } else {
            return c - 'A' + 10;
        }
    }

    private static String getFractionalPart(double decimals, int base, int precision) {
        StringBuilder fractionalPart = new StringBuilder();
        while (decimals > 0 && fractionalPart.length() < precision) {
            decimals *= base;
            int fraction = (int) decimals;
            fractionalPart.append(numberToChar(fraction));
            decimals -= fraction;
        }
        return fractionalPart.toString();
    }

    private static double getDecimalPart(String fractional, int base) {
        double decimalValue = 0;
        for (int i = 0; i < fractional.length(); i++) {
            decimalValue += charToNumber(fractional.charAt(i)) / Math.pow(base, i + 1);
        }
        return decimalValue;
    }

    private static String deleteExtraZero(String number) {
        if (number.charAt(0) == '0' && number.length() > 1) {
            return number.substring(1);
        } else {
            return number;
        }
    }
}
