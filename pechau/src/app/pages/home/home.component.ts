import { Component, HostListener } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { CommonModule } from '@angular/common';
import { ProductCardComponent } from '../../components/product-card/product-card.component';
import { AdsComponent } from '../../components/ads/ads.component';
import { CartComponent } from '../../components/cart/cart.component';
import { GetAllProductsService } from '../../services/home/get-all-products.service';
import { Injectable } from '@angular/core';

interface Product {
  imageUrl: string;
  price: string;
  description: string;
}

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NavBarComponent, ProductCardComponent,CommonModule,AdsComponent,CartComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  
  productsApi: any = [];

  constructor(private GetAllProductsService: GetAllProductsService) {
    this.getProducts();
  }

  async getProducts(){
    try {
      this.productsApi = await this.GetAllProductsService.getProducts("computer+GPU+CPU"); 
            
      console.log(`Products API: `, this.productsApi);
    } catch (error) {
      console.error('Erro ao obter produtos:', error);
    }
  }

  
}
