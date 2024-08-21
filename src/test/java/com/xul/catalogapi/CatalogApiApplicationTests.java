package com.xul.catalogapi;

import com.xul.catalogapi.Entities.Catalog;
import com.xul.catalogapi.Entities.CatalogItem;
import com.xul.catalogapi.Services.CatalogService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
class CatalogApiApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(CatalogApiApplicationTests.class);
	@Autowired
	CatalogService catalogs;

	@Test
	@Order(1)
	void populate()
	{
		// Basic data base seed
		var newTestingCatalog = new Catalog();
		var newTestingCatalog2 = new Catalog();

		newTestingCatalog.setName("test-catalog");
		newTestingCatalog2.setName("some-complex-test-name");

		List<CatalogItem> testingCatalogItems = List.of(
				new CatalogItem(newTestingCatalog,"test-item-1"),
				new CatalogItem(newTestingCatalog,"test-item-2"),
				new CatalogItem(newTestingCatalog,"test-item-3")
		);

		newTestingCatalog.setItems(testingCatalogItems);

		var savedCatalog = catalogs.save(newTestingCatalog);
		var savedCatalog2 = catalogs.save(newTestingCatalog2);

		assert(savedCatalog.getItems().size() == testingCatalogItems.size() && savedCatalog2 != null);
	}

	@Test
	@Order(2)
	void catalogRepositoryJpaMethods() {
		var findedCatalog = catalogs.findByName("test-catalog");

		assert(findedCatalog.getName().compareTo("test-catalog") == 0);
	}


	// TODO: this mf is executinge before the populate function so always fail
	@Test
	@Order(3)
	void catalogBasicSearch() {
		var allCatalogs = catalogs.getAll();
		var results = catalogs.basicSearch("test-catalog");

		var resultNames = results.stream().map(Catalog::getName).toList();

		log.warn("search query results:");

		for (String catalog : resultNames) {
			log.warn(catalog);
		}

		assert(resultNames.size() == 2);
	}
}
