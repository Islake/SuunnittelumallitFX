package facade;
public class Main {
    public static void main(String[] args) {
        JokeClient jokeClient = new JokeClient();
        try {
            String jokeText = jokeClient.getRandomJoke();
            System.out.println("Chuck Norris Joke: " + jokeText);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ApiFacade apiFacade = new ApiFacade();
        try {
            String exchangeRate = apiFacade.getAttributeValueFromJson("https://api.exchangerate-api.com/v4/latest/EUR", "rates");
            System.out.println("Exchange Rates EUR: " + exchangeRate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}