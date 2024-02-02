Menurut saya, prinsip clean code yang telah saya laksanakan adalah sebagai berikut :

- Nama variabel yang jelas

    Nama variabel yang saya berikan tidak berupa singkatan dan jelas tujuan dari pembuatan variabel tersebut apa pada kode yang saya buat
- Nama function yang baik
    
    Nama function yang saya buat juga menjelaskan tujuan dari function tersebut. Function-fuctionnya pun tidak mengubah variabel global dan hanya berfokus pada 1 kegunaan. Tiap fungsi juga hanya berupa command maupun query, tidak keduanya.
- Karena jelasnya nama variabel, function dan jelasnya alur kode, tidak diperlukannya comment. "Don't comment bad code, rewrite it."
- Alur pembuatan aplikasi dilaksanakan dengan "feature branch workflow" yang lebih aman dibandingkan trunking.

Hal yang bisa dikembangkan adalah :

- Pada saat ini, tiap orang bisa mengubah setiap product yang terdapat pada aplikasi. Selain itu, mereka bisa men-delete product hanya dengan brute force link yang dapat menyebabkan terdeletenya seluruh database. Kedepannya diperlukan sistem autentikasi dan autorisasi sehingga yang bisa mendelete/mengubah product hanyalah mereka yang mendaftarkannya.