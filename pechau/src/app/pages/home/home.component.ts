import { Component, HostListener } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { CommonModule } from '@angular/common'; // Importe CommonModule
import { ProductCardComponent } from '../../components/product-card/product-card.component';
import { AdsComponent } from '../../components/ads/ads.component';

interface Product {
  imageUrl: string;
  price: string;
  description: string;
}

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NavBarComponent, ProductCardComponent,CommonModule,AdsComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  products: Product[] = [];
  private allProducts: Product[] = [
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$1.099', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    
  ];
  
  private currentIndex: number = 0;

  constructor() {
    this.loadMoreProducts();
  }

  @HostListener('window:scroll', ['$event'])
  onScroll(event: Event) {
    if (window.innerHeight + window.scrollY >= document.body.offsetHeight) {
      this.loadMoreProducts();
    }
  }

  loadMoreProducts(): void {
    const nextProducts = this.loadProducts(this.currentIndex);
    console.log('Next Products:', nextProducts);
    this.products = [...this.products, ...nextProducts];
    this.currentIndex += nextProducts.length;
  }


  loadProducts(start: number, count: number = 5): Product[] {
    return this.allProducts.slice(start, start + count);
  }
}
