public class Exercise5 {
    public static void main(String[] args) {
        int test = 8;
        String part1 = "For ";
        String part2 = " blocks the number of ways to make a staircase is ";
        System.out.println(part1 + test + part2 + Floors(test) + ".");
    }

    //counts how many ways the blocks can be arranged to make more than one floor
    public static int MoreFloors(int n) {
        int count = 0;
        for (int i = 1; i < (n / 2) + 1; i++) {
     /*this excludes the case of n/2 with even numbers, but still counts
     how many ways it can be partitioned*/
            if (n % 2 == 0 && i == n / 2) {
                count += MoreFloors(i);
            } else {
                count++;
                count += MoreFloors(i);
            }
        }
        return count;
    }
    //this adds the case when the blocks make only one floor
    public static int Floors(int n) {
        return MoreFloors(n) + 1;
    }
}
