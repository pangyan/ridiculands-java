package com.ridiculands.stream.benchmarkmethod.marshall;

import com.ridiculands.stream.benchmarkmethod.BenchmarkMethod;
import com.ridiculands.stream.benchmarkmethod.BenchmarkMethodFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *    size: large - 100000
 *    pipeline: list --> stream --> map --> sum
 *    operation: sum
 *    collection: arrayList
 */
public class LargeArrayListMarshallBenchmarkMethodFactory implements BenchmarkMethodFactory {
    private static final List<Order> l = prepareTestOrders();
    private JAXBContext context = JAXBContext.newInstance(Order.class);

    public LargeArrayListMarshallBenchmarkMethodFactory() throws JAXBException {
    }

    @Override
    public String getBenchmarkMethodName() {
        return "Large Array List Benchmark";
    }

    @Override
    public BenchmarkMethod createLoopBenchmarkMethod() {
        return () -> {
            for (int i = 0; i < l.size(); i++) {
                try {
                    transform(l.get(i));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Override
    public BenchmarkMethod createSequentialStreamBenchmarkMethod() {
        return () -> {
            l.stream().map(i -> {
                try {
                    return transform(i);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        };
    }

    @Override
    public BenchmarkMethod createParallelStreamBenchmarkMethod() {
        return () -> {
            l.parallelStream().map(i -> {
                try {
                    return transform(i);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
        };
    }

    // TODO ISRAELW
    private static List<Order> prepareTestOrders() {
        List<Order> orders = new ArrayList<>();
        Order order;

        for (int i = 0; i < 5; i++) {
            order = new Order();
            order.setAmount(BigDecimal.TEN);
            order.setCreateDate(LocalDate.now());
            order.setOrderId("DN202310192106-" + i);
            order.setDirection("BUY");
            order.setClientReferenceId("CL202310192107-" + i);
            order.setProductId("0056");
            orders.add(order);
        }

        return orders;
    }

    private String transform(Order order) throws Exception {
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        m.marshal(order, os);
        return new String(os.toByteArray());
    }
}
