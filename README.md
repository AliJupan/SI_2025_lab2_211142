
# Али Жупани 211142

## **Control Flow Graph**

![ControlFlowDiagram](https://github.com/user-attachments/assets/ef2efb44-86bd-47d1-a61f-77656b43461c)

## **Цикломатска комплексност**

34 edges
23 nodes
V(G) = 34 - 23 + 2 = 13

## **Тест случаи според критериумот Every statement**

1. testAllItemsNull
   Проверува ако листата е null
   Треба да фрли порака: "allItems list can't be null!"

2. testEmptyItemName
   Проверува ако предметот нема име
   Треба да фрли порака: "Invalid item!"

3. testInvalidCardCharacter
   Проверува ако картичката има букви
   Треба да фрли порака: "Invalid character in card number!"

4. testInvalidCardLength
   Проверува ако картичката има помалку од 16 цифри
   Треба да фрли порака: "Invalid card number!"

5. testHighPriceDiscountAndQuantity
   Предмет со голема цена, попуст и количина
   Треба да врати: 3930.0

6. testNormalItemNoDiscount
   Предмет без попуст
   Треба да врати: 200.0

7. testNormalItemWithDiscount
   Предмет со попуст 
   Треба да врати: 210.0

Treba da ima minimum 5 testovi
## **Тест случаи според критериумот Every path**

1. TC1 (A=false, B=false, C=false):
   Првичниот услов е false, значи условот не е исполнет. Поставува основа за тестирање кога сите услови се false.

2. TC2 (A=true, B=false, C=false):
    A е true, така што условот е исполнет.

3. TC3 (A=false, B=true, C=false):
   B е true, така што условот е исполнет.

4. TC4 (A=false, B=false, C=true):
   C е true, така што условот е исполнет.

5. TC5 (A=true, B=true, C=false):
   A и B се true, така што условот е исполнет.

6. TC6 (A=true, B=false, C=true):
   A и C се true, така што условот е исполнет.

7. TC7 (A=false, B=true, C=true):
   B и C се true, така што условот е исполнет.

8. TC8 (A=true, B=true, C=true):
   A, B и C се true, така што условот е исполнет.

Treba da ima minimum 8 testovi deka 2^3  = 8





