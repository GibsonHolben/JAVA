


class Dog {
    Dog() {
        try {
            throw new Exception();

        } catch (Exception e) {
        }

    }
}
    class Test {
        public static void main(String[] args) {
            Dog d1 = new Dog();
            Dog d2 = new Dog();
            Dog d3 = d2;
            // do complex stuff
            System.out.println("break");
        }
    }