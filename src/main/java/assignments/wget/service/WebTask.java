package main.java.assignments.wget.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class WebTask implements Callable<Void> {

    private String url;
    private int depth;
    private int maxDepth;
    private ExecutorService pool;

    public WebTask(String url, int depth, int maxDepth, ExecutorService pool) {
        this.url = url;
        this.depth = depth;
        this.maxDepth = maxDepth;
        this.pool = pool;
    }

    @Override
    public Void call() throws Exception {
        if (depth > maxDepth) return null;

        // 1. Vai buscar a página com Jsoup
        Document document = Jsoup.connect(url).get();

        // 2. Guarda o conteúdo localmente
        try {
            String fileName = url.replaceAll("[^a-zA-Z0-9]", "_") + ".html";
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(document.html());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        // 3. Para cada link, submete uma nova WebTask com depth + 1
        if (depth < maxDepth) {
            document.select("a[href]").forEach(link -> {
                String nextUrl = link.attr("abs:href");
                pool.submit(new WebTask(nextUrl, depth + 1, maxDepth, pool));
            });
        }

        return null;
    }
}
