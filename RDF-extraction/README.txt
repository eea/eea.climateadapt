
How to extract data in RDF format:

1. Check out RDFExport from SVN https://svn.eionet.europa.eu/repositories/Reportnet/RDFExport
and build it

2. Modify the rdfexport to find the JAR files the right places.

3. Run the 'runit' script

After importing the data into a SPARQL database you can do this:

----------------
PREFIX foaf: <http://xmlns.com/foaf/0.1/>
PREFIX dcterms: <http://purl.org/dc/terms/>
PREFIX ca: <http://rdfdata.eionet.europa.eu/climateadapt/ontology/>

SELECT ?title sql:group_concat(?country,', ') AS ?countries ?description ?website
WHERE {
    ?project a ca:Measure ;
              dcterms:title ?title;
              dcterms:description ?description;
              foaf:page ?website;
              dcterms:spatial ?ucountry
  ?ucountry rdfs:label ?country
}
----------------
