**TEMA 1**
------------------------------------------------------
DESCRIEREA CLASELOR AUXILIARE FOLOSITE:
-Parser: cuprinde metodele: 	ParseBook 
				ParseLanguage
				ParseAuthor
				ParseEditorialGroup
				ParsePublishingBrand
				ParsePublishingRetailer
				ParseCountries 
				SimpleParse
(primesc o linie de text, creeaza un obiect din tokenurile extrase si il returneaza)
==========
-Printer: cuprinde metodele: 	printListBooks
				printListCountries
				printSetBooks
				printSetLanguages
(primesc o lista, o parcurg, concateneaza la output rezultatul metodei publish si il afiseaza)
=========
-Searcher: cuprinde metodele:	SearchBook
				SearchAuthor 
				SearchLanguage
				SearchEditorialGroup
				SearchPublishingBrand
				SearchPublishingRetailer
				SearchCountries
(primesc o lista de obiecte si un id, cauta obiectul cu respectivul id in lista si apoi il returneaza)
========
-Sistem: cuprinde metodele: 	2 categorii:1.	readData-> in functie de Case(stabilit in main) parseaza linie cu linie si adauga in lista aferente
				   	    2.	associateData-> asociaza datele intre ele
(Sistem se comporta ca o baza de date, retine absolut toate informatiile in listele aferente(de carti, de autori etc))

========
-Test :  cuprinde metodele: 	TestMethod1
				TestMethod2
				TestMethod3
				TestMethod4
				TestMethod5

(apeleaza metodele din Administration, redirecteaza outputul in fisierele din folderul output)



------------------------------------------------------
DESCRIEREA METODELOR IMPLEMENTATE IN ADMINISTRATION:
(in primul rand, clasa Administration preia toate datele din sistem)

*Set<Book>getBooksForPublishingRetailerID(int publishingRetailerID)
Cauta publishingbrandul cu id-ul primit in lista de publishingbrands. Dupa ce il gaseste, parcurge in lista aferenta acestuia de artifacts si face urmatoarele:
daca gaseste o instanta de carte, o adauga in set
daca gaseste o instanta de editorialgroup, cauta in lista acestuia de carti si adauga cartile publicate de editorialgroup
daca gaseste un publishingBrand atunci cauta in lista acestuia de carti publicate si le adauga in lista
(faptul ca lucrez cu un set ma asigura ca nu o sa am duplicate)

*Set<Language> getLanguagesForPublishingRetailerID(int publishingRetailerID)
Cauta publishingbrandul cu id-ul primit in lista de publishingbrands.Dupa ce il gaseste, parcurge in lista aferenta acestuia de artifacts si face urmatoarele:
daca gaseste o instanta de carte, foloseste search a afle limba in care e scrisa cartea respectiva si adauga limba in liusta de limbi 
daca gaseste o instanta de editorialgroup, ia carte cu carte sdin lista aferenta de carti si foloseste search a afle limba in care e scrisa cartea respectiva si adauga limba in lista de limbi 
idem pt publishingBrand


*List<Countries> getCountriesForBookID(int bookID)
parcurge toti PublishingRetailer iar daca cartea pe care o caut e publicata de catre un retailer, atunci returnez lista de tari in care publica respevctivul retailer

*List<Book>getCommonBooksForRetailerIDs(int retailerID1, int retailerID2)
Iau cele doua liste de carti unice publicate de cei doi retaileri si compara toate cartile doua cate doua in functie de ISBN si adauga in lista atunci cand gaseste doua carti cu ISBN comun

*Set<Book>getAllBooksForRetailerIDs (int retailerID1, int retailerID2)
adfauga toate cartile primului retailer,si apoi le adauga pe cele din al doilea

