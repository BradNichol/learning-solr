package uk.co.bradleynichol.learningSolr;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, SolrServerException {
		SpringApplication.run(Application.class, args);

		String urlString = "http://localhost:8983/solr/testCore";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
		solr.setParser(new XMLResponseParser());

		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "123");
		document.addField("name", "Brad Nichol");
		document.addField("job", "Developer");
		solr.add(document);
		solr.commit();

	}

}
