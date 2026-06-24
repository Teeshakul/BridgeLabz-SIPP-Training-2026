public class EarthVolume {
    public static void main(String[] args) {
        double r = 6378;
        double volume = (4.0 / 3) * Math.PI * r * r * r;

        System.out.println("Volume = " + volume);
    }
}