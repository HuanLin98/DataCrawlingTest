# DataCrawlingTest

Using the venom crawler by Preferred.AI to crawl the data of Steam games of all the genres, link: https://store.steampowered.com/.

Still a work in progress to crawl the first 3 pages of each genre due to the usage of span links by Steam.

How to run the Steam Games crawler:
1) Go to the main directory and run `mvn compile`
2) Then run `mvn exec:java -Dexec.mainClass="ai.preferred.crawler.steamGames.master.ListingCrawler"`


Done by Huan Lin
