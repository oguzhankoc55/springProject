# Spring Project
#Görev 1
Bu proje, basit bir Spring Boot uygulamasıdır. Kitapları yöneten basit bir CRUD (Create, Read, Update, Delete) işlevselliği sunmaktadır.

## Başlangıç

### Gereksinimler
- Java 8 veya üstü
- Maven
- Bir Java IDE (IntelliJ IDEA, Eclipse vb.)

### Proje İndirme
Proje dosyalarını bilgisayarınıza indirin veya terminal veya komut istemcisinde şu komutu kullanarak proje dizinine gidin:
```bash git clone <proje-repo-linki> ```
Uygulamayı Çalıştırma
Proje dizininde terminal veya komut istemcisine gidin ve aşağıdaki komutu kullanarak uygulamayı başlatın:

```bash mvn spring-boot:run ```


Uygulama başladıktan sonra, tarayıcınızdan http://localhost:8080 adresine giderek uygulamayı görebilirsiniz.

### Örnek Veritabanı Kayıtları
Uygulama başlatıldığında, CommandLineRunner tarafından önceden tanımlanmış bazı örnek kitap kayıtları eklenir.

### Kullanım
Uygulama başlatıldıktan sonra, aşağıdaki endpoint'leri kullanarak kitaplar üzerinde CRUD işlemleri gerçekleştirebilirsiniz:

#### Ana Sayfa: 
http://localhost:8080/
#### Tüm Kitapları Listele: 
http://localhost:8080/books
#### Belirli Bir Kitabı Görüntüle: 
http://localhost:8080/get/{id}
#### Kitap Ekleme: 
http://localhost:8080/create (POST)
#### Kitap Güncelleme: 
http://localhost:8080/update/{id} (PUT)
#### Kitap Silme: 
http://localhost:8080/delete/{id} (DELETE)
Her bir endpoint'in nasıl kullanılacağı hakkında daha fazla bilgiyi ilgili Controller sınıfında bulabilirsiniz.
