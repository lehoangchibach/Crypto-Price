public class CryptoCoinPrice {
    public static void main (String[] args){
        String coin_name = "";
        String url = "https://www.coindesk.com/data/";

        while (!coin_name.equals("no")) {
            StdOut.println("Crypto coin: ");
            coin_name = StdIn.readLine();
            In inHTML = new In(url);
            String html = inHTML.readAll();

            coin_name = String.join("-", coin_name.strip().toLowerCase().split(" "));

            int beg = html.indexOf(coin_name, html.indexOf("<div class=\"containerstyles__StyledContainer-sc-292snj-0 bsLqCg\"><div class=\"price-liststyles__PriceListWrapper-sc-1adi55e-0 cQXuZr\"><div class=\"price-liststyles__OptionsWrapper-sc-1adi55e-7 bvzUXZ\"><div "));
            int from = html.indexOf("hSygEo", beg);
            int end = html.indexOf("<", from + 5);
            String price = html.substring(from + 8, end);

            if (price.charAt(0) == '$')
            StdOut.println(price);
            else StdOut.println("Coin's name is invalid!");
            StdOut.println();

            StdOut.println("Do you want to continue? (<no> to stop)");

        }
    }
}
