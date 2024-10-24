package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONObject;

@WebServlet("/geoIpServlet")
public class geoIp extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String TOKEN = "38d231550b9d03";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ip = request.getParameter("ip");

        if (ip != null && !ip.isEmpty()) {

            String urlString = "https://ipinfo.io/" + ip + "?token=" + TOKEN;
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }

            br.close();
            conn.disconnect();

            JSONObject json = new JSONObject(result.toString());

            request.setAttribute("city", json.getString("city"));
            request.setAttribute("region", json.getString("region"));
            request.setAttribute("country", json.getString("country"));
            request.setAttribute("loc", json.getString("loc"));
            request.setAttribute("org", json.getString("org"));
            request.setAttribute("timezone", json.getString("timezone"));
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
