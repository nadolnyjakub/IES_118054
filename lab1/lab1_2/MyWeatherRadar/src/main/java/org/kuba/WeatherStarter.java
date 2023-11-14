package org.kuba;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import org.kuba.weather.ipma_client.IpmaCityForecast;
import org.kuba.weather.ipma_client.IpmaService;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    private static final Logger logger = LogManager.getLogger(WeatherStarter.class);

    //todo: should generalize for a city passed as argument
    private static int CITY_ID = -1;


    public static void  main(String[] args ) {
        logger.info("We've just greeted the user!");

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type the city code:");
        CITY_ID = scanner.nextInt();

        // prepare the call to remote endpoint
        Call<IpmaCityForecast> callSync = service.getForecastForACity(CITY_ID);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                System.out.printf( "max temp for %s is %4.1f %n",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()));
                logger.info("Valid request!");
            } else {
                System.out.println( "No results for this request!");
                logger.error("Bad request!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}