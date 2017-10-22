import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SimpleCrawlerSample {
    public static void main(String[] args) {
        // ブログの記事一覧ページのURL
        String url = "http://takezoe.hatenablog.com/";
        // GETリクエストを送信し、レスポンスをDocumentオブジェクトで取得
        try {
            Document doc = Jsoup.connect(url).get();
            // JQueryと同様のCSSセレクタで検索結果のリンクを抽出
            Elements elements = doc.select("a.entry-title-link");
            // 抽出したリンクを1件ずつ処理
            for(Element element: elements) {
                // リンクのラベルを取得
                String title = element.text();
                // リンクのURLを取得
                String nextUrl = element.attr("href");
                // リンク先のページを取得
                Document nextDoc = Jsoup.connect(nextUrl).get();
                // 記事の内容をHTMLで取得
                String content = nextDoc.select("div.entry-content").html();
                // 「タイトル.html」というファイル名で記事の内容を保存
                Files.write(Paths.get(title + ".html"), content.getBytes("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
