import models.Location;
import presenters.GetLocationInfoByLatlngPresenter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private Scanner scanner;

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void init() {
        while (true) {
            clearScreen();
            scanner = new Scanner(System.in);
            System.out.println("Please select running mode first:");
            System.out.println("1) Find place by latitude and longitude.");
            System.out.println("2) Calculate distance between 2 points on the map (defined by Latng).");
            System.out.println("3) QUIT");

            System.out.print("---Your choice: ");
            int ans = scanner.nextInt();
            if (ans == 1) {
                showNameByPos();
            } else if (ans == 2) {
                CalculateDistance();
            } else if (ans == 3) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    private void showNameByPos() {
        Location location = new Location(0.,0.);
        System.out.println("Please enter the latitude and longitude");

        System.out.print("---Latitude: ");
        double temp = scanner.nextFloat();
        location.setLat(temp);

        System.out.print("---Longitude: ");
        temp = scanner.nextFloat();
        location.setLng(temp);
        GetLocationInfoByLatlngPresenter presenter = new GetLocationInfoByLatlngPresenter();
        presenter.getInfoByLatlng(location);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void CalculateDistance() {
        Location first = new Location(0.,0.);
        Location second = new Location(0.,0.);
//-------------------
        System.out.println("Please enter the latitude and longitude of the first point");
        System.out.print("---(1) Latitude: ");
        double temp = scanner.nextFloat();
        first.setLat(temp);

        System.out.print("---(1) Longitude: ");
        temp = scanner.nextFloat();
        first.setLng(temp);
//--------------------
        System.out.println("Please enter the latitude and longitude of the second point");
        System.out.println("---(2) Latitude: ");
        temp = scanner.nextFloat();
        second.setLat(temp);

        System.out.println("---(2) Longitude: ");
        temp = scanner.nextFloat();
        second.setLng(temp);
    }
}
