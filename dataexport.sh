# ask for time
read -p 'Daten zurück bis: ' after
# d43a1375208c old container
# new container  a611bc8b1543
# newest container f03727dc4ee5
# newest new 6d6bf917dfb1
# newest new newest 0ad6ef9171ad
# cpu usage
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.cpu&format=csv&after=-${after}" >> cpu.csv
# cpu limit (totale cpu usage im limit)
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.cpu_limit&format=csv&after=-${after}" >> cpu_limit.csv
# cpu pressure stall info (if some were waiting)
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.cpu_some_pressure&format=csv&after=-${after}" >> cpu_some_pressure.csv
# pressure stall time (time processes have been waiting)
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.cpu_some_pressure_stall_time&format=csv&after=-${after}" >> cpu_some_pressure_stall_time.csv
# full pressure_stall_time
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.cpu_full_pressure_stall_time&format=csv&after=-${after}" >> cpu_full_pressure_stall_time.csv

# memory util (in percentage)
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.mem_utilization&format=csv&after=-${after}" >> mem_utilization.csv
# memory usage (anon, kernel_stack, slab, file)
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.mem&format=csv&after=-${after}" >> mem.csv
# memory pressure stall info
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.mem_some_pressure&format=csv&after=-${after}" >> mem_some_pressure.csv
# mem stall time
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.mem_some_pressure_stall_time&format=csv&after=-${after}" >> mem_some_pressure_stall_time.csv
# memory writeback (dirty, writeback) memory waiting to be written to disk, writeback is actively being written
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.writeback&format=csv&after=-${after}" >> mem_writeback.csv

# disk amount of data transformed (read, write)
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.io&format=csv&after=-${after}" >> io.csv
# number of io operations
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.serviced_ops&format=csv&after=-${after}" >> serviced_ops.csv
# io stalling
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.io_some_pressure&format=csv&after=-${after}" >> io_some_pressure.csv
# stall time due to io
curl -Ss "http://localhost:19999/api/v1/data?chart=cgroup_0ad6ef9171ad.io_some_pressure_stall_time&format=csv&after=-${after}" >> io_some_pressure_stall_time.csv