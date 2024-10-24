<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Geolocalización de IP</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <body>
        <div class="container">
            <h1>Geolocalización de Dirección IP</h1>
            <form action="geoIp" method="get">
                <label for="ip">Ingrese la dirección IP : </label>
                <input type="text" id="ip" name="ip" placeholder="Ej. 8.8.8.8" required>
                <button type="submit">Consultar</button>
            </form>

            <div test="${not empty city}">
                <div class="result">
                    <h2>Resultados para la IP ingresada:</h2>
                    <p><strong>🌍 Ubicación:</strong> ${city}, ${region}, ${country}</p>
                    <p><strong>📍 Coordenadas:</strong> ${loc}</p>
                    <p><strong>🏢 Organización:</strong> ${org}</p>
                    <p><strong>🕒 Zona Horaria:</strong> ${timezone}</p>
                </div>
            </div>
        </div>
        <footer>Creado por Braulio Ruiz Niñoles</footer>
    </body>

    </html>