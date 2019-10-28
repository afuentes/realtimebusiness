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

Note : using OpenJDK11U

2- Configure Kibana 

```shell
$ ...
```

### Reference

* https://www.elastic.co




