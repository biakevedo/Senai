create schema ecommerce;

create table ecommerce.cliente (
	cliente_id int primary key generated always as identity, 
	nome_completo text not null,
	email text,
	senha text not null, 
	telefone varchar(13),
	data_cadastro date
);

create table ecommerce.pedido (
	pedido_id int primary key generated always as identity,
	data_pedido timestamptz not null,
	status text not null,
	valor_total numeric(10,4) not null,
	cliente_id int REFERENCES ecommerce.cliente(cliente_id)
);

create table ecommerce.produto (
	produto_id int primary key generated always as identity,
	nome_produto text not null,
	descricao text,
	preco numeric(10,4) not null,
	estoque_disponivel int not null,
	imagem_url text 
);

create table ecommerce.pagamento (
	pagamento_id int primary key generated always as identity,
	status text not null, 
	data_pedido timestamptz not null,
	pedido_id int not null references ecommerce.pedido(pedido_id),
	forma_pagamento text not null
);

create table ecommerce.itemdopedido (
	item_id int primary key generated always as identity,
	quantidade int not null,
	produto_id int not null references ecommerce.produto(produto_id),
	pedido_id int not null references ecommerce.pedido(pedido_id)
);

create table ecommerce.cliente (
    cliente_id int primary key generated always as identity, 
    nome_completo text not null,
    email text,
    senha text not null, 
    telefone varchar(13),
    data_cadastro date
);

create table ecommerce.pedido (
    pedido_id int primary key generated always as identity,
    data_pedido timestamptz not null,
    status text not null,
    valor_total numeric(10,4) not null,
    cliente_id int not null,  -- Adicionando a coluna para chave estrangeira
    foreign key (cliente_id) references ecommerce.cliente(cliente_id) -- Chave estrangeira corretamente referenciada
);

create table ecommerce.produto (
    produto_id int primary key generated always as identity,
    nome_produto text not null,
    descricao text,
    preco numeric(10,4),
    estoque_disponivel int not null,
    imagem_url text 
);

create table ecommerce.pagamento (
    pagamento_id int primary key generated always as identity,
    status text not null, 
    data_pagamento timestamptz not null, -- Alterei para adicionar a data de pagamento
    pedido_id int not null, -- Coluna para chave estrangeira
    forma_pagamento text not null,
    foreign key (pedido_id) references ecommerce.pedido(pedido_id) -- Chave estrangeira corretamente referenciada
);

create table ecommerce.itemdopedido (
    item_id int primary key generated always as identity,
    quantidade int not null,
    produto_id int not null,  -- Coluna para chave estrangeira de produto
    pedido_id int not null,   -- Coluna para chave estrangeira de pedido
    foreign key (produto_id) references ecommerce.produto(produto_id),
    foreign key (pedido_id) references ecommerce.pedido(pedido_id)
);
