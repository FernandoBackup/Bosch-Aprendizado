import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { AdsComponent } from './components/ads/ads.component';

export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    // { path: 'navbar', component: NavBarComponent }, // Removido, pois navBar é um componente da Home
    // { path: 'product', component: ProductCardComponent }, // Removido, pois ProductCard é usado dentro da Home
    {path:"ads", component: AdsComponent},
    { path: '**', redirectTo: 'home' }
];
