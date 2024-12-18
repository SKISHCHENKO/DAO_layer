SELECT product_name
FROM public.orders
         JOIN public.customers ON orders.customer_id = customers.id
WHERE LOWER(customers.name) = LOWER(:name);