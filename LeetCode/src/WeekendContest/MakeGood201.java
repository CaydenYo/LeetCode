package WeekendContest;

/**
 * @Author cayden
 * @Date 2020/8/8 10:30 下午
 */
public class MakeGood201 {
    public String makeGood(String s){
        if (s == null || s.equals("")){
            return "";
        }
        for (int i = 1;i < s.length();i++){
            if (Math.abs(s.charAt(i - 1) - s.charAt(i)) == 32){
                int len = s.length();
                if (i == 1){
                    return makeGood(s.substring(i + 1, len));
                }else {
                    return makeGood(s.substring(0, i - 1) + s.substring(i + 1, len));
                }
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(new MakeGood201().makeGood(s));
    }
}
