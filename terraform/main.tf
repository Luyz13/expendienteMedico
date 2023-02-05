terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 2.15.0"
    }
  }
}

provider "docker" {}

resource "docker_image" "expedienteapp" {
  name         = "expedienteapp:latest"
  keep_locally = false
}

resource "docker_container" "expedienteapp" {
  image = docker_image.expedienteapp.latest
  name  = "expedienteapp"
  ports {
    internal = 8080
    external = 8080
  }
}