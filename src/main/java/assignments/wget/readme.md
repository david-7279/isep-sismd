## Applying threadpools: Very Simple Wget

1. Wget (https://www.gnu.org/software/wget/) is a tool for retrieving websites and store them in a local browsable copy.
   This type of job is suitable to be implemented using a threadpool since processing files from a website and
   retrieving links can be done in parallel. The goal of this exercise is to implement a very simple version of Wget
   where a base url pointing to a webpage is given and links from that page are retrieved and stored locally. It is not
   necessary to maintain a browsable local copy (since this would imply some html processing work), just copy files up
   to a given depth or number of links visited using a threadpool as the manager of threads which process such tasks.
   Jsoup (https://jsoup.org/) is a library allowing easy parsingof html files. For example, retrieving a web page can be
   done with:

   ```java
   import org.jsoup.Jsoup;
   import org.jsoup.nodes.Document;
   import org.jsoup.nodes.Element;
   import org.jsoup.select.Elements;
   ```

   ```java
   Document document = Jsoup.connect(url).get();
   ```

   and processing each link with:

   ```java
   Elements links = document.select("a[href]");
   for (Element link : links) {
      String nextUrl = link.attr("abs:href");
    ...
   }
   ```

---

## Perspective

This assignment focus in applying threadpools to real world examples. In summary, upon completion you should understand:

- How to configure a Threadpool to suit a given problem.
- The utility of Callabales and Futures.

---

## Notes

- `depth` — a profundidade atual desta tarefa (em que "andar" estou agora)
- `maxDepth` — o limite máximo que o utilizador define (até onde quero ir)

Então se `maxDepth` = 2:

- URL inicial → `depth` 0
- Links que encontra → `depth` 1
- Links desses links → `depth` 2
- Links desses → `depth` 3 → 🛑 para!
