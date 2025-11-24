# SklepLopata — Spring Boot • MySQL • Thymeleaf

Aplikacja sklepu internetowego stworzona jako projekt szkolny z wykorzystaniem Spring Boot 3.  
Zawiera obsługę produktów, koszyka, zamówień oraz prosty panel administratora.  


## Technologie

- **Java 17**
- **Spring Boot 3**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf**
- **MySQL**
- **Maven**
- **Lombok**


## Struktura projektu

```
src/main/java/pl/zajecia/skleplopata
│
├── controller/
│ ├── HomeController  obsługa strony głównej i koszyka
│ ├── OrderController  obsługa zamówień
│ └── AdminController  panel zarządzania produktami
│
├── dto/order/
│ ├── Order  DTO zamówienia
│ ├── OrderItem  DTO pozycji zamówienia
│ └── OrderDto  prezentacja zamówienia
│
├── mapper/
│ └── OrderMapper  mapowanie encji na DTO
│
├── model/
│ └── Item encja produktu
│
├── repository/
│ ├── ItemRepository  repozytorium produktów
│ ├── OrderRepository  repozytorium zamówień
│ └── OrderItemRepository  repozytorium pozycji zamówienia
│
├── service/
│ ├── CartService  logika koszyka
│ └── OrderService  logika składania zamówień
│
├── Cart  reprezentacja koszyka
├── CartItem  element koszyka
├── DbInit  inicjalizacja przykładowych danych
├── ItemOperation  operacje na produktach
```


## Funkcjonalności strony

### Strona główna
- wyświetlanie listy produktów (`Item`)
- podgląd szczegółów
- dodawanie produktów do koszyka

### Koszyk
- dodawanie i usuwanie produktów
- automatyczne przeliczanie wartości
- przechodzenie do podsumowania zamówienia

### Zamówienia
- tworzenie zamówienia z koszyka
- generowanie pozycji zamówienia (`OrderItem`)
- mapowanie do DTO (`OrderDto`)
- zapis w bazie danych

### Panel administratora
- dodawanie produktu
- usuwanie i edycja



## Wymagana baza danych

Projekt korzysta z bazy MySQL.  

Przed uruchomieniem utwórz bazę danych:

```sql
CREATE DATABASE sklep;
```
