public class Prac1 {
    
    public static interface Phone {
        void captureImage();
        void makeACall();

        default void batteryStatus(){
            System.out.println("Battery is 90%");
        }
        static void softwareUpdate(){
            System.out.println("Updating Software...");
        }

        default int calc(int a, int b){
            int ans = add(a,b);
            return ans;
        }
        private int add(int a, int b){
            return a+b;
        }
    }

    public static class Iphone implements Phone{
        @Override
        public void captureImage() {
            System.out.println("Capturing...");
        }

        @Override
        public void makeACall(){
            System.out.println("Calling...");
        }

    }



    public static void main(String[] args) {

        Phone iphone = new Iphone();
        iphone.captureImage();
        iphone.makeACall();
        iphone.batteryStatus();
        Phone.softwareUpdate();

        System.out.println(iphone.calc(10, 1));
        
    }
}
