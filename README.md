# Todo Uygulaması - Kubernetes Öncesi Konteynerleştirme

Bu proje, Kubernetes ortamına geçmeden önce Spring Boot Todo uygulamasının konteynerleştirilmesini göstermektedir.

## Konteynerleştirme

Proje, çok aşamalı bir Docker yapısı kullanılarak konteynerleştirilmiştir:

1. İlk aşamada Maven ile uygulama derlenir
2. İkinci aşamada sadece çalıştırılabilir JAR dosyası hafif bir JRE imajına kopyalanır

## Docker Compose ile Çalıştırma

Uygulamayı PostgreSQL veritabanı ile birlikte çalıştırmak için:

```bash
docker-compose up -d
```

Bu komut:

- PostgreSQL veritabanını başlatır
- Spring Boot uygulamasını derler ve başlatır
- Tüm gerekli ağ ve bağlantıları yapılandırır

## Manuel Docker İşlemleri

Manuel olarak Docker imajı oluşturmak için:

```bash
docker build -t todoapp:v1 .
```

Manuel olarak Docker konteynerini çalıştırmak için:

```bash
docker run -p 8080:8080 -e SPRING_PROFILES_ACTIVE=docker todoapp:v1
```

## Kubernetes'e Hazırlık

Bu konteynerleştirme adımı, uygulamayı Kubernetes'te çalıştırmak için gerekli hazırlıktır. Bir sonraki adımda, Kubernetes yapılandırma dosyaları (YAML) oluşturulacak ve uygulama Kubernetes cluster'ına deploy edilecektir.
