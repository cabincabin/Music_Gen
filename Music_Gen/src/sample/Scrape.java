package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Scrape {

    public WebDriver driver;

    public String currentNode;

    public PrintWriter writer;

    public Scrape() throws Exception{
        startDriver();
        FileWriter write = new FileWriter("Hello.txt", true);
        writer = new PrintWriter(write);
        findChords();
        writer.close();
    }

    public static void main(String[] args) throws Exception{
        Scrape scrape = new Scrape();
    }

    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Floris\\Documents\\TribalWarsBot\\lib\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }

    public void goToHome() {
        driver.get("https://www.hooktheory.com/trends#");
    }

    public void goToNode(String node) {
        currentNode = node;
        driver.get("https://www.hooktheory.com/trends#node=" + node + "&key=C");
        driver.navigate().refresh();
    }

    public void findChords() throws IOException,InterruptedException {
        String[] root;
        String[] subroot;
        String[] subsubroot;
        for(int i = 1; i < 7; i++) {
            goToNode(Integer.toString(i));
            root = getInfo();
            for(int j = 1; j < 7 ; j++) {
                goToNode(Integer.toString(i) + "." + Integer.toString(j));
                subroot = getInfo();
                for(int k = 1; k < 7; k++) {
                    goToNode(Integer.toString(i) + "." + Integer.toString(j) + "." + Integer.toString(k));
                    subsubroot = getInfo();
                    if(subroot[0].equals("") || root[0].equals("") || subsubroot[0].equals("")){
                    } else {
                        writeToFile(root[0], root[1], false);
                        writeToFile(subroot[0], subroot[1], false);
                        writeToFile(subsubroot[0], subsubroot[1], true);
                    }
                }
            }
            root = null;
        }
    }

    public String[] getInfo() throws InterruptedException{
        WebElement info = driver.findElement(By.id("cp-results-title"));

        String print[] = info.getText().split(" ");

        if(print.length < 2){
            Thread.sleep(2000);
            print = info.getText().split(" ");
        }

        String key = "";
        String percentage = "";

        //System.out.println("Key: " + print.length);

        if(print.length > 2) {
            percentage = print[2].replace("(", "").replace("%)", "");
            key = print[print.length - 1];

            System.out.println("Key: " + key + " Percentage: " + percentage);
            //writeToFile(key,percentage,newline);
        }

        String[] returnString = {"", ""};
        returnString[0] = key;
        returnString[1] = percentage;
        return returnString;
    }

    public void writeToFile(String key, String percentage, boolean newline) {
        if(newline) {
            writer.println(key + "," + percentage);
        } else {
            writer.print(key + "," + percentage + ",");
        }
    }
}
