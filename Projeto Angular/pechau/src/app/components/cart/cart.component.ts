import { Component } from '@angular/core';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent {
  ngOnInit(){
    const cartContainer = document.querySelector('.cart-container') as HTMLElement;
const body = document.body;

cartContainer.addEventListener('mouseenter', () => {
    body.classList.add('body-blur');
});

cartContainer.addEventListener('mouseleave', () => {
    body.classList.remove('body-blur');
});

  }
}
