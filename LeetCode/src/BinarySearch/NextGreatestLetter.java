package BinarySearch;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if (letters[mid] == target){
               while(mid <= right && letters[mid] == target){
                   mid++;
               }
               return letters[mid % letters.length];
            }
            if (letters[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        if (letters[left] <= target){
            return letters[(left + 1) % letters.length];
        }
        return letters[left];
    }

    public char nextGreatestLetter1(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }

    public static void main(String[] args){
        char[] letters = {'e','e','e','e','e','n','n','n','n'};
        System.out.println(new NextGreatestLetter().nextGreatestLetter(letters, 'e'));
    }
}
