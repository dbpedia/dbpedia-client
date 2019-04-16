import org.apache.jena.query.ResultSet
import org.apache.jena.query.Query
import org.apache.jena.query.QueryExecution
import org.apache.jena.query.QueryExecutionFactory
import org.apache.jena.query.QueryFactory

object SelectQuery {

  def execute(queryString:String) {
    var query: Query = QueryFactory.create(queryString)
    var qexec: QueryExecution = QueryExecutionFactory.sparqlService("http://databus.dbpedia.org/repo/sparql", query)


    try {
      var results: ResultSet = qexec.execSelect

      while (results.hasNext()) {
        println(results.nextSolution())

      }
    } finally qexec.close()


  }


}

