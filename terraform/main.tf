terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 2.15.0"
    }
  }
}

provider "docker" {
  host    = "npipe:////.//pipe//docker_engine"
}

resource "docker_image" "expedienteapp" {
  name = "expedienteapp:latest"
  keep_locally = false
}

resource "docker_image" "mysql" {
  name = "mysql"
  keep_locally = false
}

resource "docker_network" "private_network" {
  name = "my_network"
  driver = "bridge"
}

resource "docker_container" "mysql" {
	image = docker_image.mysql.latest
	name = "dbserver"
	env = [
		"MYSQL_ROOT_PASSWORD=secret",
      	"MYSQL_DATABASE=expedienteDB",
      	"MYSQL_USER=user",
      	"MYSQL_PASSWORD=pass",
      	"MYSQL_ROOT_HOST=127.0.0.1"
	]
	volumes {
    	host_path      = "/mysql_data"
    	container_path = "/var/lib/mysql"
	}
	entrypoint = [
	]
	networks_advanced {
    name    = docker_network.private_network.name
    }
}

resource "docker_container" "expedienteapp" {
  image = docker_image.expedienteapp.latest
  name  = "expedienteapp"
  ports {
    internal = 8080
    external = 8080
  }
  networks_advanced {
    name    = docker_network.private_network.name
    }
	depends_on = [
    	docker_container.mysql
	 ]
}
