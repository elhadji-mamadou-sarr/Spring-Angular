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
