//Abaixo criamos os types Sale, SaleSum, SaleSuccess
//o type Seller nós importamos do arquivo seller.ts

import { Seller } from "./seller";

export type Sale = {
  id: number;
  visited: number;
  deals: number;
  amount: number;
  date: string;
  seller: Seller;
};

//as infos do SalePage nos pegaremos na Sales pagination do Postman. Utilizaremos somente os endpoints abaixo
//a "?" diZ que é opcional o preenchimento no DataTable enquanto os demais itens sao obrigatorios
export type SalePage = {
  content?: Sale[];
  last: boolean;
  totalElements: number;
  totalPages: number;
  size?: number;
  number: number;
  first: boolean;
  numberOfElements?: number;
  empty?: boolean;
};

export type SaleSum = {
  sellerName: string;
  sum: number;
};

export type SaleSuccess = {
  sellerName: string;
  visited: number;
  deals: number;
};
