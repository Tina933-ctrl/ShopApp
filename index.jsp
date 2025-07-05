<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ro">
<head>
    <meta charset="UTF-8">
    <title>ShopApp - Bine ai venit!</title>
    <style>
        :root {
            --bg-color: white;
            --text-color: black;
            --header-bg: orange;
            --nav-bg: #ffd699;
        }
        body.dark {
           --bg-color: #1c1c1c;
           --text-color: #f1f1f1;
           --header-bg: #333;
           --nav-bg: #555;
        }
        body {
            background-color: var(--bg-color);
            color: var(--text-color);
            font-family: 'Segoe UI', sans-serif;
            text-align: center;
            margin: 0;
            padding: 0;
            transition: all 0.3s ease;
        }
        header {
            background-color: var(--header-bg);
            color: white;
            padding: 20px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        img.logo {
            width: 150px;
            margin-top: 10px;
        }
        nav {
            margin: 30px 0;
        }
        nav a {
            display: inline-block;
            margin: 0 15px;
            padding: 10px 20px;
            background-color: var(--nav-bg);
            color: var(--text-color);
            text-decoration: none;
            border-radius: 8px;
            transition: background-color 0.3s ease;
        }
        nav a:hover {
            background-color: var(--header-bg);
            color: white;
        }
        .toggle-mode {
            margin-top: 10px;
            cursor: pointer;
            background-color: transparent;
            border: 2px solid var(--text-color);
            padding: 8px 16px;
            border-radius: 5px;
            color: var(--text-color);
        }
        footer {
            margin-top: 40px;
            color: gray;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
<%-- Construim URL-ul către logo, cu context path automatizat --%>
<c:url value="/images/shopapp-logo.png" var="logoUrl"/>

<header>
    <img src="${logoUrl}" alt="ShopApp Logo" class="logo" onerror="this.style.display='none'" />
    <h1>Bine ai venit în ShopApp</h1>
    <p>Aplicația ta pentru gestionarea produselor, clienților și vânzărilor</p>
    <button class="toggle-mode" onclick="toggleTheme()">Comută Light / Dark</button>
</header>

<nav>
    <a href="<c:url value='/customers'/>">Clienți</a>
    <a href="<c:url value='/products'/>">Produse</a>
    <a href="<c:url value='/sales'/>">Vânzări</a>
</nav>

<footer>
    &copy; 2025 ShopApp. Toate drepturile rezervate.
</footer>

<script>
    function toggleTheme() {
        document.body.classList.toggle('dark');
    }
</script>
</body>
</html>
