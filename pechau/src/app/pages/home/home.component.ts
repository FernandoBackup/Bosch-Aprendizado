import { Component, HostListener } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { CommonModule } from '@angular/common';
import { ProductCardComponent } from '../../components/product-card/product-card.component';
import { AdsComponent } from '../../components/ads/ads.component';
import { CartComponent } from '../../components/cart/cart.component';

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
  products: Product[] = [];
  private allProducts: Product[] = [
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://media.pichau.com.br/media/catalog/product/cache/2f958555330323e505eba7ce930bdf27/m/c/mcr-hzn21-bl116120v3216.jpg', price: 'R$29.999', description: 'Monitor Gamer Mancer Horizon Z21, 21.45 Pol. Va, Full HD, 1ms, 75Hz, FreeSync, VGA/HDMI, MCR-HZN21-BL1' },
    { imageUrl: 'https://media.pichau.com.br/media/catalog/product/cache/2f958555330323e505eba7ce930bdf27/k/i/kit-r7-serie-5-b450m-ddr4-steel-legend-002_1.jpg', price: 'R$29.999', description: 'Pichau Kit upgrade, AMD Ryzen 7 5700X, B450M Steel Legend DDR4, 8GB DDR4' },
    { imageUrl: 'https://media.pichau.com.br/media/catalog/product/cache/2f958555330323e505eba7ce930bdf27/t/g/tgt-gt730-v32.jpg', price: 'R$29.999', description: 'Placa de Video TGT GT 730 V3, 4GB, DDR3, 128-bit, TGT-GT730-V3' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    { imageUrl: 'https://a-static.mlcdn.com.br/800x560/placa-de-video-msi-geforce-rtx-4090-gaming-x-slim-24gb-gddr6x-384-bits/inpower4/6027/32eca955dd4dbf06c14b2c29eb8e2bd6.jpeg', price: 'R$29.999', description: 'Placa de Vídeo MSI GeForce RTX 4090 Gaming X Slim 24GB GDDR6X 384 bits' },
    
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
