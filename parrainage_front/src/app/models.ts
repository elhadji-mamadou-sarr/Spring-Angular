
export interface Parrain{
  id : number,
  nom : string,
  prenom : string,
  numElecteur : number,
  numIdentite : number,
  localite : string,
  dateSignature : Date
}

export interface Collecteur{
  id : number,
  nom : string,
  prenom : string,
  numElecteur : number,
}


export interface Candidat{
  id : number,
  nom : string,
  party : string,
  fiches?: Fiche[]
}


export interface DelegueRegional{
  id : number,
  nom : string,
  prenom : string,
  numElecteur : number,
}

export interface Fiche{
  id : number,
  numero : number,
  candidat? : Candidat | null,
  delegueRegional? : DelegueRegional | null,
  region? : Region | null,
  collecteur? : Collecteur | null,
  parrains?: Parrain[] | null
}


export interface Region{
  id : number,
  nom : number,
}

export interface User{
  id?: string,
  username : string | null,
  password : string | null,
  roles ?: Role []
}

export interface Role{
  id : string,
  name : string,
}

export interface Page<T> {
  content: T[];
  pageable: {
    pageNumber: number;
    pageSize: number;
    sort: {
      empty: boolean;
      sorted: boolean;
      unsorted: boolean;
    };
    offset: number;
    unpaged: boolean;
    paged: boolean;
  };
  totalElements: number;
  totalPages: number;
  last: boolean;
  size: number;
  number: number;
  sort: {
    empty: boolean;
    sorted: boolean;
    unsorted: boolean;
  };
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}
