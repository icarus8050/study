package item_10;

public final class PhoneNumber implements Comparable<PhoneNumber> {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            System.out.println("is same reference!");
            return true;
        }
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) obj;
        return pn.lineNum == this.lineNum && pn.prefix == this.prefix
                && pn.areaCode == this.areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    @Override
    public int compareTo(PhoneNumber o) {
        int result = Short.compare(areaCode, o.areaCode);
        if (result == 0) {
            result = Short.compare(prefix, o.prefix);
            if (result == 0) {
                result = Short.compare(lineNum, o.lineNum);
            }
        }
        return result;
    }
}
