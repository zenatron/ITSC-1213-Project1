public class TestHarness {
    public static void main(String[] args) {
        Member person1 = new Member();
        Member person2 = new Member("Serena", "Williams", true, "credit card");

        person1.printMember();
        person2.printMember();
    }
}
