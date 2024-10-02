import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class GetAllProductsService {

  constructor() { }

  getProducts(target:String){
    return fetch(`https://pixabay.com/api/?key=46198349-fb3bf9b0dd83292a45f6359c2&q=${target}&image_type=photo&per_page=30`) 
        .then(res => {
            if (!res.ok) {
                throw new Error('Network response was not ok');
            }
            return res.json();
        })
        .then(data => {
          console.log(data);
          return data.hits; 
        });
  }
}
