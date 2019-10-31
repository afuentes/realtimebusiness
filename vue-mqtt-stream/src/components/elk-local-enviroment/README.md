# ELK 


## Prepared Enviroment

1- Download Platform ( ElasticSearch & Kibana ) 

* ElasticSearch from https://www.elastic.co/downloads
* Kibana from https://www.elastic.co/downloads

 
2- Configure ElasticSearch 

```shell
$ cd toolset

$ tar xvfz elasticsearch-7.4.1-no-jdk-darwin-x86_64.tar.gz
$ ./elasticsearch-7.4.1/bin/elasticsearch
```

Validate the ElasticSearch Running 

```shell
$  curl http://localhost:9200/
{
  "name" : "???????",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "LuQNvhoBSIWlhCxF1YLSsw",
  "version" : {
    "number" : "7.4.1",
    "build_flavor" : "default",
    "build_type" : "tar",
    "build_hash" : "fc0eeb6e2c25915d63d871d344e3d0b45ea0ea1e",
    "build_date" : "2019-10-22T17:16:35.176724Z",
    "build_snapshot" : false,
    "lucene_version" : "8.2.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```

ElasticSearch Cluster Detail 

```shell
$ curl -X GET "localhost:9200/_cat/health?v&pretty"
epoch      timestamp cluster       status node.total node.data shards pri relo init unassign pending_tasks max_task_wait_time active_shards_percent
1572296709 21:05:09  elasticsearch green 
```


Note : using OpenJDK11U

3- Create a document 

```shell
$ curl -X POST -H "Content-Type: application/json"  -i http://localhost:9200/mkyong/posts/1002 --data '{
  "title": "Java 8 Optional In Depth",
  "category":"Java",
  "published_date":"23-FEB-2017",
  "author":"Rambabu Posa"
}'
HTTP/1.1 201 Created
Location: /mkyong/posts/1002
Warning: 299 Elasticsearch-7.4.1-fc0eeb6e2c25915d63d871d344e3d0b45ea0ea1e "[types removal] Specifying types in document index requests is deprecated, use the typeless endpoints instead (/{index}/_doc/{id}, /{index}/_doc, or /{index}/_create/{id})."
content-type: application/json; charset=UTF-8
content-length: 158

{"_index":"mkyong","_type":"posts","_id":"1002","_version":1,"result":"created","_shards":{"total":2,"successful":1,"failed":0},"_seq_no":0,"_primary_term":1}
```

2- Configure Kibana 

```shell
$ ...
```

### Reference

* https://www.elastic.co
* https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started.html





