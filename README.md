# Product Management Demo

Jednoduchá full-stack aplikácia vytvorená ako technické zadanie. Aplikácia umožňuje zobraziť produkty zákazníka a meniť ich stav medzi **ON** a **OFF**.

## Použité technológie

### Backend

* Java
* Spring Boot
* Maven

### Frontend

* React
* TypeScript
* Vite
* Axios

## Funkcionalita

Aplikácia umožňuje:

* zobrazenie zoznamu produktov zákazníka,
* zobrazenie slovenského názvu produktu, ceny a aktuálneho stavu (ON/OFF),
* zmenu stavu produktu (ON/OFF),
* automatické obnovenie zoznamu po zmene stavu produktu.

Stav produktov je uchovávaný iba v pamäti počas behu aplikácie.

## Architektúra

Backend je rozdelený do štandardných vrstiev:

* Controller
* Service
* Repository
* DTO
* Model

Frontend komunikuje s backendom prostredníctvom REST API.

## API

| Metóda | Endpoint                        | Popis                      |
| ------ |---------------------------------| -------------------------- |
| GET    | `/api/v1/products/getAll`       | Získanie zoznamu produktov |
| POST   | `/api/v1/products/{id}/enable`  | Zapnutie produktu          |
| POST   | `/api/v1/products/{id}/disable` | Vypnutie produktu          |

## Spustenie aplikácie

### Backend

Backend je implementovaný ako štandardná Spring Boot aplikácia. Je možné ho spustiť priamo z vývojového prostredia (napr. IntelliJ IDEA alebo Eclipse) alebo pomocou Maven príkazu:

```text
mvn spring-boot:run
```

Backend je dostupný na adrese:

```text
http://localhost:8080
```

### Frontend

V koreňovom adresári frontend projektu spustite:

```bash
npm install
npm run dev
```

Frontend je dostupný na adrese:

```text
http://localhost:5173
```

> Pred spustením frontendu je potrebné mať spustený backend.

## Návrhové rozhodnutia

Zadanie vyžadovalo implementáciu len deaktivácie produktu. Rozhodol som sa však doplniť aj možnosť opätovnej aktivácie produktu, aby bolo možné meniť stav produktu oboma smermi počas behu aplikácie.

Na tento účel som zvolil samostatné endpointy pre aktiváciu a deaktiváciu produktu (enable / disable), pretože ide o jednoduché a čitateľné riešenie.

Alternatívnym prístupom by bolo použiť jeden PATCH endpoint na zmenu stavu produktu, čo by lepšie reprezentovalo aktualizáciu. V produkčnom projekte by som tento prístup preferoval a finálny návrh API by som konzultoval s tímom podľa dohodnutých konvencií.
## Čo by som doplnil alebo zlepšil

Ak by som mal viac času, aplikáciu by som rozšíril o funkcionality bežne používané v produkčných projektoch:

* použitie relačnej databázy (napr. PostgreSQL) spolu so Spring Data JPA,
* databázové migrácie pomocou Flyway alebo Liquibase,
* Docker Compose konfiguráciu pre jednoduché lokálne spustenie aplikácie vrátane databázy,
* unit testy a integračné testy,
* centralizované spracovanie výnimiek a konzistentné chybové odpovede API,
* autentifikáciu a autorizáciu pomocou Spring Security a JWT,
* vylepšil by som používateľské rozhranie (napr. Material UI alebo Tailwind CSS), vrátane lepšieho spracovania loading a error stavov.

Pri implementácii som sa zámerne držal rozsahu zadania a zameral sa na jednoduché, čitateľné riešenie spĺňajúce všetky požiadavky.
